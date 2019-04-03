import java.math.BigInteger;
import java.util.Random;

class RSA
{
  //creating global variables
  BigInteger n;
  BigInteger e;
  BigInteger d;
  //contructor to create keys, lcm and totient
  public void GenerateKeys(int bitLength)
  {
    Random rnd = new Random();
    //ensuring that variable p and q are prime
    int certainty = 100;
    BigInteger p = new BigInteger(bitLength, certainty, rnd);
    BigInteger q = new BigInteger(bitLength, certainty, rnd);
    n = p.multiply(q);
    //creating gcd
    BigInteger gcd = p.subtract(BigInteger.ONE).gcd(q.subtract(BigInteger.ONE));
    //using gcd to create lcm
    BigInteger lcm = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)).divide(gcd);
    BigInteger totient = lcm;

    //to make variable e
    do
    {
      e = new BigInteger(bitLength, certainty, rnd);
    }
    //checking that e follows all the rules it should to craete variable d
    while (e.compareTo(BigInteger.ONE) < 0|| e.compareTo(totient) > 0 || (totient.remainder(e).compareTo(BigInteger.ZERO) == 0));
    d = e.modInverse(totient);

  }
  //Encrypting constructor
  public BigInteger Encrypt(BigInteger message)
  {
    if (n == null || e == null)
    {
      return null;
    }
    //returns encrypted message if variables n and e equal a value
    return  message.modPow(e, n);
  }
  //Decrypting contstructor
  public BigInteger Decrypt(BigInteger encrypted_message)
  {
    if (n == null || d == null)
    {
     return null;
   }
   //inverse of encryption, taking encrypted code and doing the inverse of encrypting
   return  encrypted_message.modPow(d, n);
   
  }
}
