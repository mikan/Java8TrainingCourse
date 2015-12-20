/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

// Import Java types
var JString = java.lang.String;
var Paths = java.nio.file.Paths;
var Files = java.nio.file.Files;
var StandardCharsets = java.nio.charset.StandardCharsets;
var FXCollections = javafx.collections.FXCollections;
var PieChart = javafx.scene.chart.PieChart;

// Constants
var INPUT_FILE = "data.json";

// Main
var contents = new JString(Files.readAllBytes(Paths.get(INPUT_FILE)), StandardCharsets.UTF_8);
var json = JSON.parse(contents);
var list = [];
for (var n in json.populations) {
  var continent = json.populations[n].continent;
  var population = json.populations[n].population;
  list[n] = new PieChart.Data(continent, population);
}
var chart = new PieChart(FXCollections.observableArrayList(list));
$STAGE.scene = new javafx.scene.Scene(chart);
$STAGE.title = "Population of the Continents";
