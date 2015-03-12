public class AccountTester {

    public static void main (String [ ] args) {
        Account mike;
        mike = new Account (1000);
        System.out.println (mike.balance ());
        mike.deposit (100);
        System.out.println (mike.balance ());
        mike.withdraw (200);
        System.out.println (mike.balance ());


        //-----------------------//
        System.out.println("----------------------------------");
        System.out.println("Modifying withdrawal behavior TEST:\n");
        Account thai = new Account(100);
        System.out.println("created Thai's account with initial $100\n");
        
        System.out.println("Thai deposits $50");
        thai.deposit(50);
        System.out.println("Thai's account's balance is " + thai.balance());

        System.out.println("\nThai deposits $-10");
        thai.deposit(-10);
        System.out.println("Thai's account's balance is " + thai.balance());

        System.out.println("\nThai tries to withdraw $200");
        thai.withdraw(200);
        System.out.println("Thai's account's balance is " + thai.balance());

        System.out.println("\nThai tries to withdraw $60");
        thai.withdraw(60);
        System.out.println("Thai's account's balance is " + thai.balance());

        System.out.println("\nThai tries to withdraw -30");
        thai.withdraw(-30);
        System.out.println("Thai's account's balance is " + thai.balance());

        System.out.println("\nThai tries to withdraw $90");
        thai.withdraw(90);
        System.out.println("Thai's account's balance is " + thai.balance());

        System.out.println("\nThai tries to withdraw $20");
        thai.withdraw(20);
        System.out.println("Thai's account's balance is " + thai.balance());


        System.out.println("\n----------------------------------");
        System.out.println("Merging accounts TEST:\n");
        
        Account young = new Account(300);
        System.out.println("created Young's account with initial $300");

        Account lee = new Account(500);
        System.out.println("created Lee's account with initial $500\n");

        System.out.println("Merge Lee's account into Young's account");
    	young.merge(lee);

    	System.out.println("\nYoung's account's balance is " + young.balance());
    	System.out.println("\nLee's account's balance is " + lee.balance());


    	System.out.println("\n----------------------------------");
        System.out.println("Overdraft protection TEST:\n");

        Account kathy = new Account(500);
        System.out.println("created Kathy's account with initial $500");

        Account megan = new Account(200, kathy);
        System.out.println("created Megan's account with initial $200, and Megan's account is Kathy");

        System.out.println("\nattempted withdraw $50 from Megan");
        megan.withdraw(50);
        System.out.println("Megan has " + megan.balance() + ",Kathy has " + kathy.balance());

        System.out.println("\nMegan deposits $50");
        megan.deposit(50);
        System.out.println("Megan has " + megan.balance() + ",Kathy has " + kathy.balance());   

        System.out.println("\nattempted withdraw $750 from Megan");
        megan.withdraw(750);
        System.out.println("Megan has " + megan.balance() + ",Kathy has " + kathy.balance());

        Account john = new Account(100, megan);
        System.out.println("created John's account with initial $100 and John'parent account is Megan");

		System.out.println("\nattempted withdraw $750 from John");       
		john.withdraw(750);

		System.out.println("John has " + john.balance());
		System.out.println("Megan has " + megan.balance());
		System.out.println("Kathy has " + kathy.balance());
    }
}
