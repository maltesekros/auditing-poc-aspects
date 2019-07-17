curl -X PUT -H "Content-Type: application/json" -d '{ "id" : "1", "name" : "internazionale" }' http://localhost:8080/sports/teams
curl -X PUT -H "Content-Type: application/json" -d '{ "id" : "2", "name" : "valletta fc" }' http://localhost:8080/sports/teams

curl http://localhost:8080/sports/teams/1