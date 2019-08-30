$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/feature/API_Test.feature");
formatter.feature({
  "name": "Testing the API Scripts",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify the GET and POST scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "call GET method",
  "keyword": "Given "
});
formatter.match({
  "location": "API_Step_def.call_GET_method()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "call POST method",
  "keyword": "Given "
});
formatter.match({
  "location": "API_Step_def.call_POST_method()"
});
formatter.result({
  "status": "passed"
});
});