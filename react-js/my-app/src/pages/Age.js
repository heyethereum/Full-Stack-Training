import React from "react";

const Age = () => {
  const peopleArr = [
    { name: "Piggy", age: 21 },
    { name: "Puppy", age: 41 },
    { name: "Kitty", age: 61 },
    { name: "Bunny", age: 81 },
  ];
  return (
    <section className="section">
      <div className="container">
        {peopleArr.map(({ name, age }, index) => {
          return (
            <div key={index} className={age > 50 ? "red" : ""}>
              Name: {name}, Age: {age}
            </div>
          );
        })}
      </div>
    </section>
  );
};

export default Age;
