# llama_party

This is the source for the llama party service. The services provided are:
- /stores: provides the list of known stores
- /snackStore: provides the items and cost for a store
- /llama: provides the llama's preference for each snack item

## List all the stores
url: /stores  
example call: curl localhost:8080/stores  
\["Store1","Store2"\]  
  
## Get a map of all the items and costs for a provided store
url: /snackStore?store=\[controlled vocabulary as given by /stores\]  
response structure:  list of objects with field name: alphanumeric price: positive integer  
examples calls: curl localhost:8080/snackStore?name=Store1  
\[{"name":"Snack1","price":2},{"name":"Snack2","price":1}\]
curl localhost:8080/snackStore?name=UNKNOWN_STORE  
\[\] 
  
## Get the llama's preference score for a given snack  
url: /llama?snack=\[controlled vocabulary as given by /snackStore\]  
response structure: object with field name: alphanumeric 
example calls: curl localhost:8080/llama?snack=Snack1  
{"name":"Snack1","preferenceScore":1}
curl localhost:8080/llama?snack=UNKNOWN_SNACK  
{"name":""}
