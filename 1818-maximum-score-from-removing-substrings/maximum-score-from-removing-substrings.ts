function maximumGain(s: string, x: number, y: number): number {
  let a = 0, b = 0, ab = 0, ba = 0, adb = 0, bda = 0, r = 0
  const n = s.length
  for (let i = 0; i<n; i++) switch (s.charCodeAt(i)) {
    case 97: //'a'
      a++
      adb++
      if (bda > 0) {
        bda--
        ba++
      }
      break;

    case 98: //'a'
      b++
      bda++
      if (adb > 0) {
        adb--
        ab++
      }
      break;

    default:
      if (a > 0 || b > 0) {
        r += x > y ? x * ab + y * (Math.min(a, b) - ab) : x * (Math.min(a, b) - ba) + y * ba
        a = 0
        b = 0
        ab = 0
        ba = 0
        adb = 0
        bda = 0
      }
      break;

  }

  return r + (x > y ? x * ab + y * (Math.min(a, b) - ab) : x * (Math.min(a, b) - ba) + y * ba)
};