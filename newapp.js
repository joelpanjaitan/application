const fs = require("fs");
const path = require("path");
let pathFolder = path.join(__dirname, "storage", "files");
let nameFile = "message.log";
let pathFile = path.join(pathFolder, nameFile);
fs.access(pathFile, fs.constants.F_OK, (err) => {
  if (err) {
    console.log(`${nameFile} tidak ada.`);
  } else {
    console.log(`${nameFile} ada.`);
  }
});

let text = `Klik link berikut untuk mengajuan motor Honda: {url}`;
let text2 = `Gunakan kode voucher {code} dapatkan diskon s.d 1 juta untuk pemesanan motor`;
let result = [];
const matches = /\{([^{}]+)\}/g;
let match;
while ((match = matches.exec(text2)) !== null) {
  result.push(match[1]);
}
// console.log(result);

const dayjs = require("dayjs");
const duration = require("dayjs/plugin/duration");

dayjs.extend(duration);

const unixTime = 19999999;

let date = dayjs.unix(unixTime);
const targetDate = dayjs("2024-01-01 00:00:00");
const minuteDifference = targetDate.diff(date, "minute");
const newDate = date.add(minuteDifference, "minute");
const resultDate = newDate.format("YYYY-MM-DD hh:mm:ss");
// console.log(resultDate);
// const newDate = date.add(90, "minute");
let StaffData = [
  { name: "1299", gender: "F", birthDate: "2000-01-01" },
  { name: "2", gender: "male", birthDate: "2000-01-02" },
  { name: "3", gender: "male ", birthDate: "2000-01-02" },
  { name: "4", gender: "male", birthDate: "2000-01-02" },
];
// console.log(
//   StaffData.map(
//     (object) => `${object.name} ${object.gender} ${object.birthDate}`
//   )
// );
// let result = [];
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
