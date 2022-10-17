import { useState, useEffect } from "react";
import axios from "axios";

const useFetchData = async (url, method, headers) => {
  const [data, setData] = useState({});
  const [error, setError] = useState({});
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data: response } = await axios({
          method: method,
          url: url,
          headers: headers,
        });
        setData(response);
      } catch (error) {
        console.log(error);
        setError(error);
      }
      setLoading(false);
    };
    fetchData();
  }, [url, headers, method]);

  return { data, loading, error };
};

export default useFetchData;
