/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
     const valueMap = [
        [1000, "M"],[900, "CM"],[500, "D"],[400, "CD"],[100, "C"],[90, "XC"],
        [50, "L"],[40, "XL"],[10, "X"],[9, "IX"],[5, "V"],[4, "IV"],[1, "I"],
    ]
    let res = "";

    for(let [int , value] of valueMap){
        if(num === 0) break;
        const count = Math.floor(num / int);
        res += value.repeat(count);
        num -= count * int;
    }

    return res;
};