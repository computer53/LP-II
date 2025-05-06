function isPrime(number)
{
    if(number<2)
    {
        return false;
    }
    for(let i=2;i<number;i++)
    {
        if(number%i==0)
        {
            return false;
        }
    }
    return true;
}
function isPrimitive(g,p)
{
    const array=[]
    for(let i=1;i<p;i++)
    {
        let result=Math.pow(g,i)%p;
        if(array.includes(result))return false;
        array.push(result);
    }
    return array.length===p-1;
}

function publicKey(g,PK,p)
{
    let publicKey=Math.pow(g,PK)%p;
    return publicKey;
}

function defiiHelman()
{
    const p=parseInt(document.getElementById("prime").value);
    const g=parseInt(document.getElementById("primitive").value);
    const Xa=parseInt(document.getElementById("AlicePK").value);
    const Xb=parseInt(document.getElementById("BobPK").value);
    const resultDiv=document.getElementById("resultId");

    if(!isPrime(p))
    {
        resultDiv.innerHTML="numner is not prime number";
        return;
    }
    if(!isPrimitive(g,p))
    {
        resultDiv.innerHTML="number is not primitive root";
        return
    }

    if(Xa>p||Xb>p)
    {
        resultDiv.innerHTML="private key should be less than prime number";
        return;
    }

    const Ya=publicKey(g,Xa,p);
    const Yb=publicKey(g,Xb,p);
    const k1=publicKey(Yb,Xa,p);
    const k2=publicKey(Ya,Xb,p);

    resultDiv.innerHTML=`public key of Alice ${Ya}<br>
    public key of Bob ${Yb} <br>
    secreate key's are ${k1} & ${k2}
    <br>${k1==k2?"key exchange successful":"not sucessful"}
`


}