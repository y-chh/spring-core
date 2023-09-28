package qualifiers_lazy_initialization.repo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import qualifiers_lazy_initialization.domain.LocalDataSource;

@Component("localDataSource")
@Lazy
public class LocalDateRepo implements LocalDataSource {
    @Override
    public String fetchData() {
        return "Data fetched from Local Data Source";
    }
}
