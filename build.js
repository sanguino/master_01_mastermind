var plantuml = require('node-plantuml');
var fs = require('fs');
 
var gen = plantuml.generate("domainModel.puml");
gen.out.pipe(fs.createWriteStream("domainModel.jpg"));
console.log("domainModel.jpg generated")