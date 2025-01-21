function myAtoi(s) {
  let index = 0;
  let sign = 1;
  let result = 0;
  const INT_MAX = 2 ** 31 - 1;
  const INT_MIN = -(2 ** 31);

  while (index < s.length) {
    const char = s[index];

    if (char === ' ') {
      index++;
      continue; 
    }

    if (char === '+' || char === '-') {
      sign = char === '-' ? -1 : 1;
      index++;
      break; 
    }

    if (char >= '0' && char <= '9') {
      break; // Exit and continue with the digit processing
    }

    return 0;
  }

  // Process digits in the same loop
  while (index < s.length && s[index] >= '0' && s[index] <= '9') {
    const digit = s[index] - 0;

    if (result > Math.floor(INT_MAX / 10) || 
        (result === Math.floor(INT_MAX / 10) && digit > INT_MAX % 10)) {
      return sign === 1 ? INT_MAX : INT_MIN;
    }

    result = result * 10 + digit;
    index++;
  }

  return result * sign;
}
