import http from 'k6/http';
import {check} from 'k6';
import {FormData} from '../utils/form-data.js';

const xml = open('/resources/example-nfe.xml');

export const options = {
  iterations: 250000,
  vus: 500,
  duration: '30m',
};

const form = new FormData();
form.append('file', http.file(xml, 'example-nfe.xml', 'application/xml'));

export default function () {
  const res = http.post('http://localhost:8080/v1/nfe-upload', form.body(), {
    headers: {
      'Content-Type': 'multipart/form-data; boundary=' + form.boundary
    },
    timeout: '1m'
  });

  check(res, {
    'all NF-es uploaded with status 204': (r) => r.status === 204,
  });
}