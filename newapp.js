const dayjs = require("dayjs");
const duration = require("dayjs/plugin/duration");

dayjs.extend(duration);

const unixTime = 19999999;

let date = dayjs.unix(unixTime);
const newDate = date.addTime(90, "minute");
const resultDate = newDate.format("YYYY-MM-DD hh:mm:ss");
console.log(resultDate);
import validator from "validator";
let StaffData = [
  { name: "1299", gender: "F", birthDate: "2000-01-01" },
  { name: "2", gender: "male", birthDate: "2000-01-02" },
  { name: "3", gender: "male ", birthDate: "2000-01-02" },
  { name: "4", gender: "male", birthDate: "2000-01-02" },
];

let result = [];
function validateObject(obj) {
  let { customerName, customerPhone, customerEmail } = obj;
  const validCode = !obj.code;
  const validCustomerName =
    typeof customerName === "string" && customerName.length >= 3;
  const validCustomerPhone = validatePhone(customerPhone);
  const validCustomerEmail = validateEmail(customerEmail);
  if (
    validCode &&
    validCustomerName &&
    validCustomerPhone &&
    validCustomerEmail
  ) {
    return true;
  } else return false;
}
function validateEmail(value) {
  const isEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return value.test(isEmail);
}
function validatePhone(value) {
  const isPhone = /^[+]?[\d\s-]{7,}$/;
  return value.test(isPhone);
}
// console.log(validateObject(StaffData[0]));
// text.forEach((data, index) => result.push(index));
// result = StaffData.map(
//   (object) => `${object.name} ${object.gender} ${object.birthDate}`
// );
// function validateBirthDate(value) {
//   const regex = /^\d{4}-\d{2}-\d{2}$/;
//   if (!regex.test(value)) return false;
//   else {
//     const today = new Date(value);
//     return today.toISOString().slice(0, 10) === value;
//   }
// }

// function validateStaff(obj) {
//   let { name, gender, birthDate } = obj;
//   const validName = typeof name === "string" && name.length >= 3;
//   const validGender = gender === "M" || gender === "F";
//   const validBirthDate = validateBirthDate(birthDate);
//   if (validName && validGender && validBirthDate) {
//     return true;
//   } else return false;
// }
// console.log(validateStaff(StaffData[2]));
