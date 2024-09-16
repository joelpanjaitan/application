class DataNode {
  constructor(res = 0, left = null, right = null) {
    this.res = res;
    this.left = left;
    this.right = right;
  }
}

function treeDiameter(root) {
  let treeWidth = 0;
  function altitude(node) {
    if (node === null) return 0;
    let leftAltitude = altitude(node.left);
    let rightAltitude = altitude(node.right);

    treeWidth = Math.max(treeWidth, leftAltitude + rightAltitude + 1);

    return Math.max(leftAltitude, rightAltitude) + 1;
  }

  altitude(root);
  return treeWidth;
}

let root = new DataNode(1);
root.left = new DataNode(2);
root.right = new DataNode(3);
root.left.left = new DataNode(4);
root.left.right = new DataNode(5);

// const root = new DataNode(
//   40,
//   new DataNode(30, new DataNode(22), new DataNode(38)),
//   new DataNode(65, null, new DataNode(78))
// );

console.log(treeDiameter(root));
