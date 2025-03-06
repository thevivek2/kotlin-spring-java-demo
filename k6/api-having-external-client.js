import http from 'k6/http';
import {Counter, Rate, Trend} from 'k6/metrics';
import {sleep} from 'k6';

export let actual_http_req_duration = new Trend('actual_http_req_duration');
export let actual_http_reqs = new Counter('actual_http_reqs');
export let successful_requests = new Rate('successful_requests');

export const options = {
    stages: [
        {duration: '10s', target: 5000},
        {duration: '1000s', target: 500},
        {duration: '2s', target: 0},
    ],
};

export default function () {
    let url = 'http://localhost:8080/api/v2/example/external-api';
    let result = http.get(url);
    actual_http_req_duration.add(result.timings.duration);
    actual_http_reqs.add(1);
    /200/.test(result.status) ? successful_requests.add(true) : (successful_requests.add(false), logError(result));
    sleep(1)
}


export function logError(res) {
    console.warn(res.status, res.body);
}