import com.nhaarman.expect.BooleanMatcher
import com.nhaarman.expect.expect

//Check input validation
expect(isRomanNumber("")).toBe(false)
expect(isRomanNumber("    ")).toBe(false)
expect(isRomanNumber("12345")).toBe(false)
expect(isRomanNumber("@#$")).toBe(false)
expect(isRomanNumber("ABCD")).toBe(false)
expect(isRomanNumber("abcd")).toBe(false)

//Lesser number will follow the bigger numbers
expect(isRomanNumber("XX" + "II")).toBe(true)
expect(isRomanNumber("LXVI")).toBe(true)
expect(isRomanNumber("IIXX")).toBe(false)
expect(isRomanNumber("LC")).toBe(false)
expect(isRomanNumber("VX")).toBe(false)

// can’t have more than three in a row - I, X, or C
expect(isRomanNumber("XXXV")).toBe(true)
expect(isRomanNumber("IIII")).toBe(false)
expect(isRomanNumber("XXXX")).toBe(false)
expect(isRomanNumber("CCCC")).toBe(false)
expect(isRomanNumber("CIIII")).toBe(false)

//no more than one - V or L
expect(isRomanNumber("V")).toBe(true)
expect(isRomanNumber("L")).toBe(true)
expect(isRomanNumber("XLI")).toBe(true)
expect(isRomanNumber("LXIV")).toBe(true)
expect(isRomanNumber("VV")).toBe(false)
expect(isRomanNumber("LL")).toBe(false)
expect(isRomanNumber("CVV")).toBe(false)

//Only a single lesser numeral(X or I) can precede a bigger numeral at a time
expect(isRomanNumber("IV")).toBe(true)
expect(isRomanNumber("XIV")).toBe(true)
expect(isRomanNumber("XCIX")).toBe(true)
expect(isRomanNumber("LXXIX")).toBe(true)
expect(isRomanNumber("LXXXVIII")).toBe(true)
expect(isRomanNumber("XCIIX")).toBe(false)
expect(isRomanNumber("XIC")).toBe(false)
expect(isRomanNumber("IIV")).toBe(false)
expect(isRomanNumber("IIV")).toBe(false)
expect(isRomanNumber("XXC")).toBe(false)

//Roman Number
expect(isRomanNumber("LI")).toBe(true)
expect(isRomanNumber("I")).toBe(true)
expect(isRomanNumber("V")).toBe(true)
expect(isRomanNumber("XVIII")).toBe(true)
expect(isRomanNumber("XL")).toBe(true)
expect(isRomanNumber("XC")).toBe(true)
expect(isRomanNumber("XCIV")).toBe(true)
expect(isRomanNumber("XXXIV")).toBe(true)

