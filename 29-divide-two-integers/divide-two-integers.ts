function divide(dividend: number, divisor: number): number {
    
    let divisor_negative = divisor < 0 ? -1 : 1
    let dividend_negative = dividend < 0 ? -1 : 1
    divisor = Math.abs(divisor)
    dividend = Math.abs(dividend)

    let q = 0
    if (divisor == 1) q = dividend

    while(dividend >= divisor && divisor > 1){
        
        let temp = divisor
        let multiple = 1
        while(dividend >= (temp << 1) && (temp << 1) > 0){
            temp = temp << 1
            multiple = multiple << 1
        }
        dividend = dividend - temp
        q += multiple
    }

    if ((divisor_negative < 0 &&  dividend_negative < 0) || (divisor_negative > 0 && dividend_negative >0) ){
        q = q
    }else{
        q = -q
    }
    return Math.min( Math.max(q, -2147483648), 2147483647)
};