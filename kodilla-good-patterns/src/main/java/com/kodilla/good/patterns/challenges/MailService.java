package com.kodilla.good.patterns.challenges;

class MailService  implements InformationService{
    public void inform(User user){
        System.out.println(user.getFirstName() + " " + user.getLastName() + ", Your order is ready. We sent the order to You.\n");
    }
}
