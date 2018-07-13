
# Spring MVC with MongoDb Example 
  
This example show how can integrate spring mvc with MongoDb


> 

# Commands for MongoDb

`
mongo your_host:27017
mongo --host your_host -u dinn -p your_password --authenticationDatabase dinnd --port 27017
mongo --host your_host/dinnd -u dinn -p your_password --port 27017

show dbs
use dinnd
db.createCollection( "users" )
show collections

db.runCommand( { insert: "users", documents: [ { _id: 1, firstname: "marco", lastname: "sanchez" }] } )
db.runCommand( { insert: "users", documents: [ { _id: 2, firstname: "julia", lastname: "marquez" }] } )
db.getCollection('users').find({})
db.users.find()

` 
