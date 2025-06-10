function maxSlidingWindow(nums: number[], k: number): number[] {
  let dq = [];
  let ans = new Array<number>();

  for(let i = 0; i < k; i ++){
    while(dq.length && dq[dq.length - 1] < nums[i]){
      dq.pop();
    }
    dq.push(nums[i]);
  }

  for(let i = k ; i < nums.length; i ++){
    ans[i - k] = dq[0];
    let outgoing = nums[i - k];
    if(outgoing === dq[0]) dq.shift();
    let incoming = nums[i];
    while(dq.length && dq[dq.length - 1] < incoming){
      dq.pop();
    }
    dq.push(incoming);  
  }
  ans.push(dq[0]);

  return ans;
};