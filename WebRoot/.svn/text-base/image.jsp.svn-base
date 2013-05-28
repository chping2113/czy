 <%@   page   contentType="image/jpeg"   import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"  pageEncoding="ISO-8859-1" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  <%!   
  Color   getRandColor(int   fc,int   bc)   
  {   
  Random   random   =   new   Random();   
  if(fc>255)   fc=255;   
  if(bc>255)   bc=255;   
  int   r=fc+random.nextInt(bc-fc);   
  int   g=fc+random.nextInt(bc-fc);   
  int   b=fc+random.nextInt(bc-fc);   
  return   new   Color(r,g,b);   
  }   
  %>  
  
  <%
  out.clear();
  response.setHeader("Pragma","No-cache");   
  response.setHeader("Cache-Control","no-cache");   
  response.setDateHeader("Expires",   0);   
     
  int   width=90,   height=20;   
  BufferedImage   image   =   new   BufferedImage(width,   height,   BufferedImage.TYPE_INT_RGB);   
     
     
  Graphics   g   =   image.getGraphics();   
  Random   random   =   new   Random();   
     
  g.setColor(getRandColor(200,250));   
  g.fillRect(0,   0,   width,   height);   
     
  g.setFont(new   Font("Times   New   Roman",Font.PLAIN,18));   
     
     
     
  g.setColor(getRandColor(160,200));   
  for   (int   i=0;i<155;i++)   
  {   
  int   x   =   random.nextInt(width);   
  int   y   =   random.nextInt(height);   
  int   xl   =   random.nextInt(12);   
  int   yl   =   random.nextInt(12);   
  g.drawLine(x,y,x+xl,y+yl);   
  }   
     
     
 /* String   sRand="";   
  for   (int   i=0;i<6;i++){   
  String   rand=String.valueOf(random.nextInt(10));   
  sRand+=rand; */  
  char   c[]   =   new   char[62];   
     
  for   (int   i   =   97,   j   =   0;   i   <   123;   i++,   j++)   {   
  c[j]   =   (char)   i;   
  }   
  for   (int   o   =   65,   p   =   26;   o   <   91;   o++,   p++)   {   
  c[p]   =   (char)   o;   
  }   
  for   (int   m   =   49,   n   =   52;   m   <   58;   m++,   n++)   {   
  c[n]   =   (char)   m;   
  }                   
  String   sRand="";   
  for   (int   i=0;i<6;i++){   
  int   x   =   random.nextInt(62);   
  String   rand=String.valueOf(c[x]);   
  sRand+=rand;  
     
  g.setColor(new   Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));   
  g.drawString(rand,13*i+6,16);   
  }   
       
  session.setAttribute("rand",sRand);   
     
  g.dispose();   
    
     response.reset();
        out.clear();
        out=pageContext.pushBody();

     
  ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(image, "jpeg", sos);
		sos.close(); 
   %>
</body>
</html>