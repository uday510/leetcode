class Solution {
public:
    int maximizeSquareArea(int m, int n, vector<int>& hFences, vector<int>& vFences) {
        hFences.push_back(1);
        hFences.push_back(m);
        vFences.push_back(1);
        vFences.push_back(n);
        int hsize=hFences.size();
         int vsize=vFences.size();
        sort( hFences.begin(), hFences.end());
        sort( vFences.begin(), vFences.end());
        
        set<int> dh;
        for(int i=hsize-1;i>=0;i--){
            
            for(int j=0;j<i;j++){
                int diff=hFences[i]-hFences[j];
                dh.insert(diff);
            }
        }
        vector<int> dv;
        for(int i=vsize-1;i>=0;i--){
            
            for(int j=0;j<i;j++){
                int diff=vFences[i]-vFences[j];
                dv.push_back(diff);
            }
        }
        int long long ans=-1;
        sort( dv.begin(), dv.end());
        for(int i=dv.size()-1;i>=0;i--){
          if(  dh.find(dv[i])!=dh.end()){
              ans=dv[i];
              break;
              
          }
        }
        
        
        
        int mod=1e9+7;
        
    if(ans!=-1){
        ans=(ans*ans)%mod;
    }
        
        
       return ans; 
        
    }
};