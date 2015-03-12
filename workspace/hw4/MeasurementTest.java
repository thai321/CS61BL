import junit.framework.TestCase;


public class MeasurementTest extends TestCase {
	public void testConstructor() {
		Measurement m0 = new Measurement();
		assertTrue(m0.toString().equals("0\'0\""));
		
		Measurement m1 = new Measurement(5);
		assertTrue(m1.toString().equals("5\'0\""));
		
		Measurement m2 = new Measurement(7,2);
		assertTrue(m2.toString().equals("7\'2\""));

		Measurement m3 = new Measurement(0,0);
		assertTrue(m3.toString().equals("0\'0\""));
		
		Measurement m4 = new Measurement(123,543);
		assertTrue(m4.toString().equals("168\'3\""));
		
		Measurement m5 = new Measurement(0,1);
		assertTrue(m5.toString().equals("0\'1\""));
		
		Measurement m6 = new Measurement(1,0);
		assertTrue(m6.toString().equals("1\'0\""));
	}
	
	public void testPlus() {
		Measurement m1 = new Measurement(5,3);	// Test 2 objects with 2 arguments for each
		Measurement m2 = new Measurement(7,11); // sum is more than 12\"
		Measurement m3 = m1.plus(m2);			// m1 call, m2 is arguments
		assertTrue(m3.toString().equals("13\'2\"")); 
		m3 = m2.plus(m1);						// m2 call, m1 is arguments
		assertTrue(m3.toString().equals("13\'2\""));   
		assertTrue(m1.toString().equals("5\'3\"")); 
		assertTrue(m2.toString().equals("7\'11\"")); 
		
		
		Measurement m4 = new Measurement(5); // Test 2 objects with 1 argument and 2 arguments
		Measurement m5 = new Measurement(7,51); // more than 12\"
		Measurement m6 = m4.plus(m5);
		assertTrue(m6.toString().equals("16\'3\""));	
		m6 = m5.plus(m4);
		assertTrue(m6.toString().equals("16\'3\""));
		assertTrue(m4.toString().equals("5\'0\"")); 
		assertTrue(m5.toString().equals("11\'3\"")); 
		
		
		Measurement m7 = new Measurement(5);  // Test 2 objects with 1 argument for each
		Measurement m8 = new Measurement(7);  //\" is 0 for both objects
		Measurement m9 = m7.plus(m8);
		assertTrue(m9.toString().equals("12\'0\""));
		m9 = m8.plus(m7);
		assertTrue(m9.toString().equals("12\'0\""));
		assertTrue(m7.toString().equals("5\'0\"")); 
		assertTrue(m8.toString().equals("7\'0\"")); 
		
		
		Measurement m10 = new Measurement(5,2);   // Test 2 object with 2 argument for each
		Measurement m11 = new Measurement(7,4);	// sum is less than 12
		Measurement m12 = m10.plus(m11);
		assertTrue(m12.toString().equals("12\'6\""));
		m12 = m11.plus(m10);
		assertTrue(m12.toString().equals("12\'6\""));
		assertTrue(m10.toString().equals("5\'2\"")); 
		assertTrue(m11.toString().equals("7\'4\"")); 
		
		Measurement m13 = new Measurement();   // Test 2 object with 0 argument for each
		Measurement m14 = new Measurement();	// 0 feet and 0\"
		Measurement m15 = m13.plus(m14);
		assertTrue(m15.toString().equals("0\'0\""));	
		m15 = m14.plus(m13);
		assertTrue(m15.toString().equals("0\'0\""));	
		assertTrue(m13.toString().equals("0\'0\"")); 
		assertTrue(m14.toString().equals("0\'0\"")); 
		
		Measurement m16 = new Measurement(123,322);   // Test 2 object with 0 argument for each
		Measurement m17 = new Measurement(345,543);	// 0 feet and 0\"
		Measurement m18 = m16.plus(m17);
		assertTrue(m18.toString().equals("540\'1\""));	
		m18 = m17.plus(m16);
		assertTrue(m18.toString().equals("540\'1\""));
		assertTrue(m16.toString().equals("149\'10\"")); 
		assertTrue(m17.toString().equals("390\'3\"")); 
		
		Measurement m19 = new Measurement();   
		Measurement m20 = new Measurement(2,25);
		Measurement m21 = m19.plus(m20);
		assertTrue(m21.toString().equals("4\'1\""));	
		m21 = m20.plus(m19);
		assertTrue(m21.toString().equals("4\'1\""));	
		assertTrue(m19.toString().equals("0\'0\"")); 
		assertTrue(m20.toString().equals("4\'1\"")); 
		
		
		Measurement m22 = new Measurement(0,0);   
		Measurement m23 = new Measurement(2,6);
		Measurement m24 = m22.plus(m23);
		assertTrue(m24.toString().equals("2\'6\""));	
		m24 = m23.plus(m22);
		assertTrue(m24.toString().equals("2\'6\""));	
		assertTrue(m22.toString().equals("0\'0\"")); 
		assertTrue(m23.toString().equals("2\'6\"")); 
		
		Measurement m25 = new Measurement(0,0);   
		Measurement m26 = new Measurement(2,14);
		Measurement m27 = m25.plus(m26);
		assertTrue(m27.toString().equals("3\'2\""));	
		m27 = m26.plus(m25);
		assertTrue(m27.toString().equals("3\'2\""));	
		assertTrue(m25.toString().equals("0\'0\"")); 
		assertTrue(m26.toString().equals("3\'2\"")); 

		Measurement m28 = new Measurement(0);   
		Measurement m29 = new Measurement(2,14);
		Measurement m30 = m28.plus(m29);
		assertTrue(m30.toString().equals("3\'2\""));	
		m30 = m29.plus(m28);
		assertTrue(m30.toString().equals("3\'2\""));	
		assertTrue(m28.toString().equals("0\'0\"")); 
		assertTrue(m29.toString().equals("3\'2\"")); 
		

		Measurement m31 = new Measurement();   
		Measurement m32 = new Measurement(2,3);
		Measurement m33 = m31.plus(m32);
		assertTrue(m33.toString().equals("2\'3\""));	
		m33 = m32.plus(m31);
		assertTrue(m33.toString().equals("2\'3\""));	
		assertTrue(m31.toString().equals("0\'0\"")); 
		assertTrue(m32.toString().equals("2\'3\"")); 

		Measurement m34 = new Measurement();   
		Measurement m35 = new Measurement(2,12);
		Measurement m36 = m34.plus(m35);
		assertTrue(m36.toString().equals("3\'0\""));	
		m36 = m35.plus(m34);
		assertTrue(m36.toString().equals("3\'0\""));	
		assertTrue(m34.toString().equals("0\'0\"")); 
		assertTrue(m35.toString().equals("3\'0\"")); 

		Measurement m37 = new Measurement(4);   
		Measurement m38 = new Measurement();
		Measurement m39 = m37.plus(m38);
		assertTrue(m39.toString().equals("4\'0\""));	
		m39 = m38.plus(m37);
		assertTrue(m39.toString().equals("4\'0\""));	
		assertTrue(m37.toString().equals("4\'0\"")); 
		assertTrue(m38.toString().equals("0\'0\"")); 

		Measurement m40 = new Measurement(4);   
		Measurement m41 = new Measurement(2,4);
		Measurement m42 = m40.plus(m41);
		assertTrue(m42.toString().equals("6\'4\""));	
		m42 = m41.plus(m40);
		assertTrue(m42.toString().equals("6\'4\""));	
		assertTrue(m40.toString().equals("4\'0\"")); 
		assertTrue(m41.toString().equals("2\'4\""));

		Measurement m43 = new Measurement(0,0);   
		Measurement m44 = new Measurement(2);
		Measurement m45 = m43.plus(m44);
		assertTrue(m45.toString().equals("2\'0\""));	
		m45 = m44.plus(m43);
		assertTrue(m45.toString().equals("2\'0\""));	
		assertTrue(m43.toString().equals("0\'0\"")); 
		assertTrue(m44.toString().equals("2\'0\""));
		
		Measurement m46 = new Measurement(0,0);   
		Measurement m47 = new Measurement();
		Measurement m48 = m46.plus(m47);
		assertTrue(m48.toString().equals("0\'0\""));	
		m48 = m47.plus(m46);
		assertTrue(m48.toString().equals("0\'0\""));	
		assertTrue(m46.toString().equals("0\'0\"")); 
		assertTrue(m47.toString().equals("0\'0\""));

		Measurement m49 = new Measurement(5);   
		Measurement m50 = new Measurement(0);
		Measurement m51 = m49.plus(m50);
		assertTrue(m51.toString().equals("5\'0\""));	
		m51 = m50.plus(m49);
		assertTrue(m51.toString().equals("5\'0\""));	
		assertTrue(m49.toString().equals("5\'0\"")); 
		assertTrue(m50.toString().equals("0\'0\""));
	
		Measurement m52 = new Measurement(0,1);   
		Measurement m53 = new Measurement(1,0);
		Measurement m54 = m52.plus(m53);
		assertTrue(m54.toString().equals("1\'1\""));	
		m54 = m53.plus(m52);
		assertTrue(m54.toString().equals("1\'1\""));	
		assertTrue(m52.toString().equals("0\'1\"")); 
		assertTrue(m53.toString().equals("1\'0\""));

	}
	
	public void testMinus() {
		Measurement m1 = new Measurement(9,12);	// Test 2 objects with 2 arguments for each
		Measurement m2 = new Measurement(7,11); 
		Measurement m3 = m1.minus(m2);			// m1 call, m2 is arguments
		assertTrue(m3.toString().equals("2\'1\"")); 
		assertTrue(m1.toString().equals("10\'0\"")); 
		assertTrue(m2.toString().equals("7\'11\"")); 
		
		
		Measurement m4 = new Measurement(5); // Test 2 objects with 1 argument and 2 arguments
		Measurement m5 = new Measurement(1,23); // more than 12\"
		Measurement m6 = m4.minus(m5);
		assertTrue(m6.toString().equals("2\'1\""));	
		assertTrue(m4.toString().equals("5\'0\"")); 
		assertTrue(m5.toString().equals("2\'11\"")); 
		
		
		Measurement m7 = new Measurement(7);  // Test 2 objects with 1 argument for each
		Measurement m8 = new Measurement(5);  //\" is 0 for both objects
		Measurement m9 = m7.minus(m8);
		assertTrue(m9.toString().equals("2\'0\""));
		assertTrue(m7.toString().equals("7\'0\"")); 
		assertTrue(m8.toString().equals("5\'0\"")); 
		
		Measurement m10 = new Measurement(7,4);   // Test 2 object with 2 argument for each
		Measurement m11 = new Measurement(5,2);	// less than 12
		Measurement m12 = m10.minus(m11);
		assertTrue(m12.toString().equals("2\'2\""));
		assertTrue(m10.toString().equals("7\'4\"")); 
		assertTrue(m11.toString().equals("5\'2\"")); 
		
		Measurement m13 = new Measurement(1);   // Test 2 object with 1 argument and 2 arguments
		Measurement m14 = new Measurement(0,1);	
		Measurement m15 = m13.minus(m14);
		assertTrue(m15.toString().equals("0\'11\""));
		assertTrue(m13.toString().equals("1\'0\"")); 
		assertTrue(m14.toString().equals("0\'1\"")); 
		
		Measurement m16 = new Measurement(0,1);   // Test 2 object with 1 argument and 2 arguments
		Measurement m17 = new Measurement(0);	
		Measurement m18 = m16.minus(m17);
		assertTrue(m18.toString().equals("0\'1\""));
		assertTrue(m16.toString().equals("0\'1\"")); 
		assertTrue(m17.toString().equals("0\'0\"")); 
		
		Measurement m19 = new Measurement(8);   // Test 2 object with 1 argument and 0 arguments
		Measurement m20 = new Measurement();	
		Measurement m21 = m19.minus(m20);
		assertTrue(m19.toString().equals("8\'0\""));
		assertTrue(m20.toString().equals("0\'0\"")); 
		assertTrue(m21.toString().equals("8\'0\"")); 

		Measurement m22 = new Measurement(); 
		Measurement m23 = new Measurement();	
		Measurement m24 = m22.minus(m23);
		assertTrue(m22.toString().equals("0\'0\""));
		assertTrue(m23.toString().equals("0\'0\"")); 
		assertTrue(m24.toString().equals("0\'0\""));


		Measurement m25 = new Measurement(6,20); 
		Measurement m26 = new Measurement(7,5);	
		Measurement m27 = m25.minus(m26);
		assertTrue(m25.toString().equals("7\'8\""));
		assertTrue(m26.toString().equals("7\'5\"")); 
		assertTrue(m27.toString().equals("0\'3\""));

		Measurement m28 = new Measurement(9,2); 
		Measurement m29 = new Measurement(7,5);	
		Measurement m30 = m28.minus(m29);
		assertTrue(m28.toString().equals("9\'2\""));
		assertTrue(m29.toString().equals("7\'5\"")); 
		assertTrue(m30.toString().equals("1\'9\""));
		
		Measurement m31 = new Measurement(9,25); 
		Measurement m32 = new Measurement(7,29);	
		Measurement m33 = m31.minus(m32);
		assertTrue(m31.toString().equals("11\'1\""));
		assertTrue(m32.toString().equals("9\'5\"")); 
		assertTrue(m33.toString().equals("1\'8\""));

		Measurement m44 = new Measurement(9); 
		Measurement m45 = new Measurement(0,0);	
		Measurement m46 = m44.minus(m45);
		assertTrue(m44.toString().equals("9\'0\""));
		assertTrue(m45.toString().equals("0\'0\"")); 
		assertTrue(m46.toString().equals("9\'0\""));

		Measurement m47 = new Measurement(9); 
		Measurement m48 = new Measurement(5,3);	
		Measurement m49 = m47.minus(m48);
		assertTrue(m47.toString().equals("9\'0\""));
		assertTrue(m48.toString().equals("5\'3\"")); 
		assertTrue(m49.toString().equals("3\'9\""));



	}
	
	public void testMultiple() {
		Measurement m1 = new Measurement();
		Measurement mp = m1.multiple(2);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m1.toString().equals("0\'0\"")); 


		Measurement m2 = new Measurement(2);
		mp = m2.multiple(2);
		assertTrue(mp.toString().equals("4\'0\""));
		assertTrue(m2.toString().equals("2\'0\"")); 
		
		Measurement m3 = new Measurement(2,5);
		mp = m3.multiple(5);
		assertTrue(mp.toString().equals("12\'1\""));
		assertTrue(m3.toString().equals("2\'5\""));
	
		Measurement m4 = new Measurement(6,3);
		mp = m4.multiple(1);
		assertTrue(mp.toString().equals("6\'3\""));
		assertTrue(m4.toString().equals("6\'3\""));
		
		Measurement m5 = new Measurement(100,200);
		mp = m5.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m5.toString().equals("116\'8\""));
		
		Measurement m6 = new Measurement(0,0);
		mp = m6.multiple(1);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m6.toString().equals("0\'0\""));
		
		Measurement m7 = new Measurement(5,0);
		mp = m7.multiple(1);
		assertTrue(mp.toString().equals("5\'0\""));
		assertTrue(m7.toString().equals("5\'0\""));

		Measurement m8 = new Measurement();
		mp = m8.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m8.toString().equals("0\'0\"")); 

		Measurement m9 = new Measurement();
		mp = m9.multiple(1);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m9.toString().equals("0\'0\"")); 

		Measurement m10 = new Measurement();
		mp = m10.multiple(10);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m10.toString().equals("0\'0\"")); 

		Measurement m11 = new Measurement(1);
		mp = m11.multiple(10);
		assertTrue(mp.toString().equals("10\'0\""));
		assertTrue(m11.toString().equals("1\'0\""));

		Measurement m12 = new Measurement(4);
		mp = m12.multiple(11);
		assertTrue(mp.toString().equals("44\'0\""));
		assertTrue(m12.toString().equals("4\'0\""));

		Measurement m13 = new Measurement(0,1);
		mp = m13.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m13.toString().equals("0\'1\""));

		Measurement m14 = new Measurement(0,1);
		mp = m14.multiple(1);
		assertTrue(mp.toString().equals("0\'1\""));
		assertTrue(m14.toString().equals("0\'1\""));

		Measurement m15 = new Measurement(0,1);
		mp = m15.multiple(5);
		assertTrue(mp.toString().equals("0\'5\""));
		assertTrue(m15.toString().equals("0\'1\""));

		Measurement m16 = new Measurement(5);
		mp = m16.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m16.toString().equals("5\'0\""));

		Measurement m17 = new Measurement(1,0);
		mp = m17.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m17.toString().equals("1\'0\""));

		Measurement m18 = new Measurement(1,1);
		mp = m18.multiple(6);
		assertTrue(mp.toString().equals("6\'6\""));
		assertTrue(m18.toString().equals("1\'1\""));

		Measurement m19 = new Measurement(1,1);
		mp = m19.multiple(50);
		assertTrue(mp.toString().equals("54\'2\""));
		assertTrue(m19.toString().equals("1\'1\""));

		Measurement m20 = new Measurement(5,3);
		mp = m20.multiple(2);
		assertTrue(mp.toString().equals("10\'6\""));
		assertTrue(m20.toString().equals("5\'3\""));

		Measurement m21 = new Measurement(5,12);
		mp = m21.multiple(1);
		assertTrue(mp.toString().equals("6\'0\""));
		assertTrue(m21.toString().equals("6\'0\""));

		Measurement m22 = new Measurement(5,12);
		mp = m22.multiple(2);
		assertTrue(mp.toString().equals("12\'0\""));
		assertTrue(m22.toString().equals("6\'0\""));

		Measurement m23 = new Measurement(5,15);
		mp = m23.multiple(6);
		assertTrue(mp.toString().equals("37\'6\""));
		assertTrue(m23.toString().equals("6\'3\""));

		Measurement m24 = new Measurement(1,0);
		mp = m24.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m24.toString().equals("1\'0\""));

		Measurement m25 = new Measurement(1,0);
		mp = m25.multiple(6);
		assertTrue(mp.toString().equals("6\'0\""));
		assertTrue(m25.toString().equals("1\'0\""));

		Measurement m26 = new Measurement(1,1);
		mp = m26.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m26.toString().equals("1\'1\""));

		Measurement m27 = new Measurement(0,1);
		mp = m27.multiple(12);
		assertTrue(mp.toString().equals("1\'0\""));
		assertTrue(m27.toString().equals("0\'1\""));

		Measurement m28 = new Measurement(1);
		mp = m28.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m28.toString().equals("1\'0\""));

		Measurement m29 = new Measurement(1,0);
		mp = m29.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m29.toString().equals("1\'0\""));

		Measurement m30 = new Measurement(2,2);
		mp = m30.multiple(2);
		assertTrue(mp.toString().equals("4\'4\""));
		assertTrue(m30.toString().equals("2\'2\""));

		Measurement m31 = new Measurement(2,2);
		mp = m31.multiple(6);
		assertTrue(mp.toString().equals("13\'0\""));
		assertTrue(m31.toString().equals("2\'2\""));

		Measurement m32 = new Measurement(14,14);
		mp = m32.multiple(1);
		assertTrue(mp.toString().equals("15\'2\""));
		assertTrue(m32.toString().equals("15\'2\""));

		Measurement m33 = new Measurement(14,14);
		mp = m33.multiple(0);
		assertTrue(mp.toString().equals("0\'0\""));
		assertTrue(m33.toString().equals("15\'2\""));

		Measurement m34 = new Measurement(14,14);
		mp = m34.multiple(5);
		assertTrue(mp.toString().equals("75\'10\""));
		assertTrue(m34.toString().equals("15\'2\""));


	}

	public void testToString() {
		Measurement m1 = new Measurement();
		assertTrue(m1.toString().equals("0\'0\""));

		m1 = new Measurement(0);
		assertTrue(m1.toString().equals("0\'0\""));

		m1 = new Measurement(3);
		assertTrue(m1.toString().equals("3\'0\""));

		m1 = new Measurement(0,0);
		assertTrue(m1.toString().equals("0\'0\""));

		m1 = new Measurement(0,1);
		assertTrue(m1.toString().equals("0\'1\""));

		m1 = new Measurement(1,0);
		assertTrue(m1.toString().equals("1\'0\""));

		m1 = new Measurement(1,1);
		assertTrue(m1.toString().equals("1\'1\""));

		m1 = new Measurement(2,2);
		assertTrue(m1.toString().equals("2\'2\""));

		m1 = new Measurement(1,12);
		assertTrue(m1.toString().equals("2\'0\""));

		m1 = new Measurement(1, 15);
		assertTrue(m1.toString().equals("2\'3\""));

		m1 = new Measurement(3, 25);
		assertTrue(m1.toString().equals("5\'1\""));
	
		m1 = new Measurement(0,12);
		assertTrue(m1.toString().equals("1\'0\""));

	}
}
