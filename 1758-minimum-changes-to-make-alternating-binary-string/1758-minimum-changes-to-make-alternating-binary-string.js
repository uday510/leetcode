/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function(s) {
    const minOps = (start) => {
        let ops = 0;
        for (let c of s) {
            ops += (c == start) ? 1 : 0;
            start ^= 1;
        }
        return ops;
    }
    return Math.min(minOps(0), minOps(1));
};