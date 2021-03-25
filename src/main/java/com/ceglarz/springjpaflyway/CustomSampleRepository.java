package com.ceglarz.springjpaflyway;

import java.util.List;

public interface CustomSampleRepository {

    List<Sample> findCustom(String name);

}
