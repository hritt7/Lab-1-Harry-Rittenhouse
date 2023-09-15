/**
 * A class that represents a rational number in normal form where the numerator
 * and the denominator share no common factors and only the numerator
 * can be negative.
 * 
 * @author Charles Hoot 
 * @version 4.0
*/

public class Rational
{
    private int numer;
    private int denom;// PUT PRIVATE DATA FIELDS HERE

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {       
    this.numer = 1;
    this.denom = 1;  // ADD CODE TO THE CONSTRUCTOR
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d) throws ZeroDenominatorException
    {
        if(d == 0){
            throw new ZeroDenominatorException("denom can't = 0");
        }
       numer = n;
       denom = d;
       normalize(); // ADD CODE TO THE ALTERNATE CONSTRUCTOR
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return numer;
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return denom;
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {               
        
        return new Rational(-numer, denom);
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert() {
    if (denom == 0) {
        throw new ZeroDenominatorException("Cannot have 0");
    }
    
    if (numer < 0) {
        return new Rational(-denom, -numer); 
    } 
    
    else {
        return new Rational(denom, numer);
    }
}








    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other) {
    // Find a common denominator
    int commDenom = this.denom * other.denom;
    int newNumer1 = this.numer * other.denom;
    int newNumer2 = other.numer * this.denom;
    int sumOfNumer = newNumer1 + newNumer2;

    return new Rational(sumOfNumer, commDenom);
}

    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    /**
 * Subtract a rational number t from this one r
 *
 * @param other the second argument of subtract
 * @return a new rational number that is r - t
 */
public Rational subtract(Rational other) {
    int newNumer = (this.numer * other.denom) - (other.numer * this.denom);
    int newDenom = this.denom * other.denom;
    
    Rational result = new Rational(newNumer, newDenom);
    result.normalize();
    return result;
}


    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other) {
    int numer2 = this.numer * other.numer;
    int denom2 = this.denom * other.denom;
    return new Rational(numer2, denom2);
}
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other) {
    if (other.denom == 0) {
        throw new ArithmeticException("Cannot divide by 0");
    }
    int numer2 = this.numer * other.denom;
    int denom2 = this.denom * other.numer;
    return new Rational(numer2, denom2);
}
     
      
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * can be negative.
     *
     */
    private void normalize() {
    if (numer == 0) {
        denom = 1;
    } else {
        int commonFactor = gcd(Math.abs(numer), denom);
        numer = numer / commonFactor;
        denom = denom / commonFactor;
    }
}


private int gcd(int n, int d)
{
    while (d != 0) {
        int hold = d;
        d = n % d;
        n = hold;
    }
    return n;
}


        
// ADD CODE TO NORMALIZE THE RATIONAL NUMBER
    }
    
    
    
   
    
    

