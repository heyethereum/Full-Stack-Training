const array = [];

function add(element) {
  array.push(element);
  console.log(array);
}

add(1);
add("two");
add(3);
add({ 4: "four" });

array[4] = 5;
console.log(array);

console.log("<==========================================>");

function assign_object() {
  return {
    firstName: "Piggy",
    lastName: "Inu",
    designation: "Software Engineer",
  };
}

const object = assign_object();

for (let key in object) {
  console.log(`Key: ${key} Value: ${object[key]}`);
}

const data = [
  { name: "piggy", age: 18 },
  { name: "puppy", age: 20 },
  { name: "kitty", age: 19 },
];

for (let { name, age } of data) {
  console.log(`Name: ${name} Age: ${age}`);
}
