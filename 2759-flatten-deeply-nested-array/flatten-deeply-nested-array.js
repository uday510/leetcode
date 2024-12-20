/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {

    const result = [];

    const dfs = (nums, i) => {

        for (const num of nums) {
            if (Array.isArray(num) && i < n) {
                dfs(num, i + 1);
            } else {
                result.push(num);
            }
        }
    }

    dfs(arr, 0);

    return result;    
};