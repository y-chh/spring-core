package qualifiers_lazy_initialization.repo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import qualifiers_lazy_initialization.domain.RemoteDataSource;

@Component("remoteDataSource")
@Lazy
public class RemoteDataRepo implements RemoteDataSource {
    @Override
    public String fetchData() {
        return "Data fetched from remote data source";
    }
}

