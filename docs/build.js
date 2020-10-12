let plantuml = require('node-plantuml');
let fs = require('fs');

console.log("generating domainModel.jpg")
let gen = plantuml.generate("domainModel.puml");
gen.out.pipe(fs.createWriteStream("domainModel.jpg"));

gen = plantuml.generate("classDiagram.puml");
gen.out.pipe(fs.createWriteStream("classDiagram.jpg"));
console.log("generating classDiagram.jpg")
