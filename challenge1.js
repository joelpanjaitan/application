function findMissingProgression(characters, data) {
  data.sort((a, b) => a - b);

  let contrast = [];
  for (let [index, character] of data.entries()) {
    contrast.push(data[index] - data[index - 1]);
  }
  const differences = Math.min(...contrast.filter((item) => item > 0));
  const alpha = data[0];
  const omega = data[data.length - 1];
  const beta = (omega - alpha) / differences + 1;

  const delta = (beta / 2) * (2 * alpha + (beta - 1) * differences);

  const epsilon = data.reduce((previous, next) => previous + next, 0);
  const found = delta - epsilon;
  return found;
}
let input = `5\n1 3 5 7 11`;

const [execute, ...data] = input.split("\n")[1].split(" ").map(Number);
console.log(findMissingProgression(execute, data));
