package qualifiers_lazy_initialization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import qualifiers_lazy_initialization.domain.LocalDataSource;
import qualifiers_lazy_initialization.domain.RemoteDataSource;

@Service
public class DataService {
    private final LocalDataSource localDataSource;
    private final RemoteDataSource remoteDataSource;

    @Autowired
    public DataService(
            @Qualifier("localDataSource") LocalDataSource localDataSource,
            @Qualifier("remoteDataSource") RemoteDataSource remoteDataSource
    ) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public String getLocalData() {
        return localDataSource.fetchData();
    }

    public String getRemoteData() {
        return remoteDataSource.fetchData();
    }
}
