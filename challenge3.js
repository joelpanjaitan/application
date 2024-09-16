function calculatePatternType(dataLength) {
  const count = new Array(dataLength + 1).fill(0);
  count[0] = 1;

  if (dataLength > 0) {
    count[1] = 1;
  }

  for (let k = 2; k <= dataLength; k++) {
    count[k] = count[k - 1] + count[k - 2];
  }

  return count;
}

function progressInput(input) {
  const biggest = 50;
  const count = calculatePatternType(biggest);

  const finalData = [];
  for (const length of input) {
    if (length === 0) break;
    finalData.push(count[length]);
  }

  return finalData;
}

const sample = [1, 2, 3, 0];
console.log(progressInput(sample).join("\n"));
