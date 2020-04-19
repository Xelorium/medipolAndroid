package com.example.covidnineteen;

public class infReq extends BaseReq  {

    public infReqListener listener;

    public interface infReqListener {
        void infReqDone(String result);
    }

    public infReq(infReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php?rapidapi-key=81562325e2mshbd0d89553a475b7p15c935jsn5518849f9136";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.infReqDone(result);
    }
}
