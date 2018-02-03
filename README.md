# llama_party

This is the source for the llama party service. The services provided are:
- /stores: provides the list of known stores
- /snackStore: provides the items and cost for a store
- /llama: provides the llama's preference for each snack item

## List all the stores
url: /stores  
example call: curl localhost:8080/stores  
\["Store1","Store2"\]  
notes: Returns a json response, not a response entity  
  
## Get a map of all the items and costs for a provided store
url: /snackStore?store=\[controlled vocabulary as given by /stores\]  
response structure: key: alphanumeric value: integer  
examples calls: curl localhost:8080/snackStore?name=Store1  
{"Snack1":10,"Snack2":2}  
curl localhost:8080/snackStore?name=UNKNOWN_STORE  
{}

notes: Returns a json response, not a response entity  
  
## Get the llama's preference score for a given snack  
url: /llama  
response structure: integer  
example calls: curl localhost:8080/llama?snack=Snack1  
1  
curl localhost:8080/llama?snack=UNKNOWN_SNACK 
0
