package com.zy.bigdata.aerospike.util;

import com.aerospike.client.Host;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: hotallen
 * Date: 2017/2/13
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
final public class AerospikeConfigUtils {

    public static final int DEFAULT_AEROSPIKE_PORT = 3000;

    public static List<Host> parseHosts(String addresses) {
        return Arrays.stream(StringUtils.split(addresses, " "))
                .map(e -> {
                    String name;
                    int port;
                    if (StringUtils.contains(e, ":")) {
                        name = StringUtils.substringBefore(e, ":");
                        port = NumberUtils.toInt(StringUtils.substringAfter(e, ":"));
                    } else {
                        name = e;
                        port = DEFAULT_AEROSPIKE_PORT;
                    }
                    return new Host(name, port);
                })
                .collect(Collectors.toList());
    }

}
