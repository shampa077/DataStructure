//get html element
var cat_img = document.getElementById("cat_img");
var feed_button =document.getElementById("feed_button");
var run_button=document.getElementById("run_button");
//add an event listener
cat_img.addEventListener("click", meow);

// feed_button.addEventListener("click", function(){
// 	alert("oof");
// });

feed_button.addEventListener("click",feed);
run_button.addEventListener("click",run);

function meow()
{
	alert("Meow");
}
console.log(55+'5');
//manipulate html element
function feed()
{
	cat_img.style.width=(cat_img.offsetWidth + 30.0) +'px';
}
function run()
{
	cat_img.style.width=(cat_img.offsetWidth - 30.0) +'px';
}


var my_array =[1, 2, 3];

console.log(my_array[1]);

var my_cat={
	name:'fluffy',
	weight: 5.5,
	previous_weight: [4,3,6]
};
var my_cat2={
	name:'skinny',
	weight: 2.5,
	previous_weight: [4,3,6]
};

 
console.log(my_cat.name);
console.log(my_cat.previous_weight);


my_cat.age=5;
my_cat.weight=50;
var my_cats =[my_cat, my_cat2];
console.log(my_cats[0]);

old_array=[1,2,3];
// new_array=old_array;
// old_array[0]=10;
// console.log(old_array);
// console.log(new_array);




//Mapping to solve same reference problem while copying
// new_array=old_array.map(function(old_array_element)
// {

//  return old_array_element;

// });

//filtering

new_array=old_array.filter(function(old_array_element)
{

  return old_array_element>1;

 });
//old_array[0]=10;
console.log('old_array',old_array);
console.log('new_array',new_array);



