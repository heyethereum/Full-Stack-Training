import { useState, useEffect, useMemo } from "react";
import axios from "axios";

const useFetchData = ({ url, method, headers, body }) => {
  const [data, setData] = useState({});
  const [error, setError] = useState({});
  const [loading, setLoading] = useState(true);

  const params = useMemo(() => {
    return {
      method: method,
      url: url,
      headers: headers,
      data: body,
    };
  }, [url, method, headers, body]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data: response } = await axios(params);
        setData(response);
      } catch (error) {
        console.log(error.data);
        setError(error.data);
      }
      setLoading(false);
    };
    fetchData();
  }, [params]);

  return { data, loading, error };
};

export default useFetchData;
