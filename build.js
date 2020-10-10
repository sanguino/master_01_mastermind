var plantuml = require('node-plantuml');
var fs = require('fs');

var gen = plantuml.generate("clases.puml");
gen.out.pipe(fs.createWriteStream("clases.jpg"));
console.log("clases.jpg generated")