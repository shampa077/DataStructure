var dataUrl="https://raw.githubusercontent.com/IsaKiko/D3-visualising-data/gh-pages/code/nations.json";
d3.json(dataUrl,function (nations){
	//console.log(nations);

var filtered_nations=nations.map(function(nation_element){
 return nation_element;
});

var nationsall=nations.map(function(nation_element){
 return nation_element;
});
var chart_area =d3.select('#chart_area');



var frame =chart_area.append("svg");
var canvas=frame.append("g");
//var first_circle=canvas.append('circle');

var margin = {top: 19.5, right: 19.5, bottom: 19.5, left: 39.5};
var frame_width = 960;
var frame_height = 350;
var canvas_width = frame_width - margin.left - margin.right;
var canvas_height = frame_height - margin.top - margin.bottom;

frame.attr("width",frame_width);
frame.attr("height",frame_height);
canvas.attr("transform","translate("+margin.left+","+margin.top+")");
// first_circle.attr("cx","120px");
// first_circle.attr("cy","120px");
// first_circle.attr("r","40px");
// first_circle.attr("stroke-width",2);
// first_circle.attr("stroke","black");
// first_circle.attr("fill","green");

var xScale=d3.scale.log();
xScale.domain([250,1e5]);
xScale.range([0,canvas_width]);

var XAxis_generator_function=d3.svg.axis().orient("bottom").scale(xScale);

canvas.append("g").call(XAxis_generator_function).attr("transform","translate( 0," +canvas_height +")");


 var colorScale=d3.scale.category20();

var yScale=d3.scale.linear();
yScale.domain([10,85]);
yScale.range([canvas_height,0]);

var yAxis_generator_function=d3.svg.axis().orient("left").scale(yScale);

canvas.append("g").call(yAxis_generator_function);

var data_canvas= canvas.append("g").attr("class","data_canvas");
update();

d3.selectAll(".region_cb").on("change",function ()
{
	//check on checked item change
	// console.log(this);
	 var regiontype= this.value;
	// console.log(this.value);
	console.log(this.checked);

	if(this.checked)
	{

		var new_nations=nations.filter(function (nations_element)
		{
			return nations_element.region==regiontype;
		});
		filtered_nations=filtered_nations.concat(new_nations);
	}
	else
	{
		filtered_nations=filtered_nations.filter(function (nations_element)
		{
			return nations_element.region!=regiontype;
		});
		

	}
// 	var filtered_nations=nations.filter(function(nations_element)
// {

//   return nations_element.region==regiontype;

//  })
	//console.log(nationsall);
	console.log(filtered_nations.length);

  update();
});

var year_idx=parseInt(document.getElementById("year_slider").value);
d3.select("#year_slider").on("input",function ()
{
	year_idx=parseInt(this.value);
	console.log(year_idx);
	update();


})

update();


//all elements checked
// var magicald3linkingthing =data_canvas.selectAll(".dot").data(nations, function(d)
// 	{
// 		return d.name;

// 	});

function update(){
var magicald3linkingthing =data_canvas.selectAll(".dot").data(filtered_nations, function(d)
	{
		return d.name;

	});

// magicald3linkingthing.enter().append("circle").attr("class","dot").attr("r",5).attr("cx",function(d){

// 	return xScale(d.income[0]);

// }).attr("cy",function(d){

// 	return yScale(d.lifeExpectancy[0])

// }).style("fill",function (d)
// {
   
//    // d3.select("#c20")
//    // var a=["red", "green","yellow", "orange"];
//    // 
//    return colorScale(d.region);
// });


magicald3linkingthing.enter().append("circle").attr("class","dot").attr("r",5).style("fill",function (d)
{
   
   // d3.select("#c20")
   // var a=["red", "green","yellow", "orange"];
   // 
   return colorScale(d.region);
});




magicald3linkingthing.exit().remove();

magicald3linkingthing.transition().ease("linear").duration(200).attr("cx",function(d){

 	return xScale(d.income[year_idx-1950]);

 }).attr("cy",function(d){

 	return yScale(d.lifeExpectancy[year_idx-1950])

 });
}

});

