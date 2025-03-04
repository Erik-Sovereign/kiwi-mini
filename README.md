# Installation
Im Root Ordner:
`./mvnw clean install`

```
cd shared-models
../mvnw clean install
```

# Start und Tests
`./mvnw spring-boot:run -pl things-api`
Startet auf Port 8080
`./mvnw spring-boot:run -pl applications-api`
Startet auf Port 8081

## Beispieltests
```
# Füge ersten Charger hinzu (Tesla Wall Connector)
curl -X POST http://localhost:8080/things-api/chargers -H "Content-Type: application/json" -d '{     
  "name": "Tesla Wall Connector",
  "energyInputPerHour": 11000,
  "charging": true
}'

# Füge zweiten Charger hinzu (Heidelberg Energy Control)
curl -X POST http://localhost:8080/things-api/chargers -H "Content-Type: application/json" -d '{
  "name": "Heidelberg Energy Control",
  "energyInputPerHour": 7500,
  "charging": false
}'

# Füge Solar Panel hinzu
curl -X POST http://localhost:8080/things-api/solarpanels -H "Content-Type: application/json" -d '{
  "name": "Dachanlage Süd",
  "energyOutputPerHour": 15000
}'
```
`curl http://localhost:8081/api/energy/balance  `

`curl -X PUT http://localhost:8081/api/chargers/7c1d9a99-c435-42e3-a95d-55fe6522e787/charging -H "Content-Type: application/json" -d '{"charging": true}'`