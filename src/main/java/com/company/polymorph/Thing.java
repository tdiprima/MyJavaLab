package com.company.polymorph;

/**
 * Created by tdiprima on 12/28/15.
 */
public class Thing {
    private String whatever;

    public void identify()
    {
        System.out.println(this.getClass().getName());
    }

    public void set(String whatever)
    {
        this.whatever = whatever;
    }

    public String getWhatever()
    {
        return this.whatever;
    }
}
