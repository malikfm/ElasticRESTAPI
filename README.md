# ElasticRESTAPI
Spring Boot REST API to Elasticsearch.

<br />
<br />

## Details
### Elasticsearch
* Index: testen
* JSON format:
<pre>
{
  "category":"",
  "headline":"",
  "authors":"",
  "link":"",
  "short_description":"",
  "date":"",
  "id":""
}
</pre>

## How to compile
<pre>mvn install</pre>

<br />
<br />

## Running the program
<pre>
java -jar malik/engine/ElasticRESTAPI-0.0.1-SNAPSHOT.jar
</pre>

## Tested request
<pre>
localhost:8080/all
localhost:8080/query?category=tech&headline=&authors=willa&desc=&date=
localhost:8080/query?category=tech
localhost:8080/query?category=tech&authors=willa
localhost:8080/query?authors=willa
localhost:8080/query?authors=willa&desc=social+media
localhost:8080/query?headline=national
localhost:8080/query?desc=social+media
localhost:8080/query?category=tech&authors=willa&desc=social+media
localhost:8080/query?date=2015-11-11
</pre>