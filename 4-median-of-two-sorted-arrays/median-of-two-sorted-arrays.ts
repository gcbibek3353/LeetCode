function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    let finalArr = new Array();
    let p1 = 0;
    let p2 = 0;
    let n1 = nums1.length;
    let n2 = nums2.length;

    while (p1 < n1 || p2 < n2) {
        if (p1 >= n1) {
            finalArr.push(nums2[p2++]);
            continue;
        }
        if (p2 >= n2) {
            finalArr.push(nums1[p1++]);
            continue;
        }

        if (nums1[p1] <= nums2[p2]) {
            finalArr.push(nums1[p1++]);
        }
        else finalArr.push(nums2[p2++])
    }
    console.log(finalArr)

    let midIndex = Math.floor(finalArr.length / 2);
    console.log(midIndex);
    if (finalArr.length % 2 === 0) {
        return ((finalArr[midIndex] + finalArr[midIndex - 1]) / 2);
    }
    else return finalArr[midIndex];
};