import axios from "axios";

const BASE_URL = "http://localhost:8080/light";

const operateLight = (operation, color) => {
    return axios.post(`${BASE_URL}/${operation}/${color}`);
};

export default {
    operateLight
};