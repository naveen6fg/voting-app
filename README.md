Voting System API Usage Guide and Features

Features Implemented:
1. Enter candidate
2. Cast vote for a candidate
3. Count votes for a candidate
4. List all candidates and their vote counts
5. Get the winner (candidate with the most votes)

API Usage:
1. Enter a candidate:
   POST http://localhost:8080/entercandidate?name=<candidate_name>
   Example: http://localhost:8080/entercandidate?name=ajay

2. Cast a vote for a candidate:
   POST http://localhost:8080/castvote?name=<candidate_name>
   Example: http://localhost:8080/castvote?name=ajay

3. Count votes for a candidate:
   GET http://localhost:8080/countvote?name=<candidate_name>
   Example: http://localhost:8080/countvote?name=ajay

4. List all candidates and their vote counts:
   GET http://localhost:8080/listvote

5. Get the winner:
   GET http://localhost:8080/getwinner

All APIs return appropriate HTTP status codes and JSON responses
