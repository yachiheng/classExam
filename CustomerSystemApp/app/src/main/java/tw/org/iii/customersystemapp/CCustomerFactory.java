package tw.org.iii.customersystemapp;

import java.util.ArrayList;

public class CCustomerFactory {

    private ArrayList<CCustomer> list=new ArrayList<CCustomer>();
    private int position=0;

    public CCustomerFactory(){
        LoadData();
    }

    private void LoadData(){
        list.add(new CCustomer("001","Marco","0937445125","marco@gmai.com","台北市"));
        list.add(new CCustomer("002","Selina","0912554784","selina@gmai.com","台中市"));
        list.add(new CCustomer("005","Kymbia","0933545214","kymbia@gmai.com","高雄市"));
    }

    public void MoveToFirst(){
        position=0;
    }
    public void MoveToPrevious(){
        position--;
        if(position<0)
            position=0;
    }
    public void MoveToNext(){
        position++;
        if(position>=list.size())
            MoveToLast();
    }
    public void MoveToLast(){
        position=list.size()-1;
    }
    public void MoveTo(int index){
        position=index;
    }

    public CCustomer GetCurrent(){
        return list.get(position);
    }
    public CCustomer[] GetAll(){
        return list.toArray(new CCustomer[list.size()]);
    }






}
