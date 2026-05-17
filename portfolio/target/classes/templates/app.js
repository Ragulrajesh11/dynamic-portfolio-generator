const api = axios.create({
    baseURL: "http://localhost:8080", // 🔥 Changed to match Spring Boot port
    timeout: 5000
});